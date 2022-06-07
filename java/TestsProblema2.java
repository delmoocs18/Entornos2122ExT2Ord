import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestsProblema2 {

    private CuentaBancaria emisor;
    private CuentaBancaria destinatario;

    @BeforeEach
    public void setUp()
    {
        emisor = new CuentaBancaria(1);
        destinatario = new CuentaBancaria(2);
        emisor.setBalance(200);
    }

    @Test
    public void Transfer_emisorBalanceShouldBeReducedByAmountOfTransaccion()
    {
        emisor.transferir(50, destinatario);
        Assertions.assertEquals(150, emisor.getBalance());
    }

    @Test
    public void Transfer_destinatarioBalanceShouldBeIncreasedByAmountOfTransaccion()
    {
        emisor.transferir(50, destinatario);
        Assertions.assertEquals(50, destinatario.getBalance());
    }

    @Test
    public void Transfer_TransactionShouldBeRecordedAsDebitInemisorTransactionHistory()
    {
        emisor.transferir(50, destinatario);

        Assertions.assertEquals(1, emisor.getTransacciones().size());
        Transaccion transaccion = emisor.getTransacciones().get(0);
        Assertions.assertEquals("Cargo", transaccion.getTipoTransaccion());
        Assertions.assertEquals(destinatario, transaccion.getOtraCuenta());
        Assertions.assertEquals(50, transaccion.getCantidad());
    }

    @Test
    public void Transfer_TransactionShouldBeRecordedAsCreditIndestinatarioTransactionHistory()
    {
        emisor.transferir(50, destinatario);

        Assertions.assertEquals(1, destinatario.getTransacciones().size());
        Transaccion transaccion = destinatario.getTransacciones().get(0);
        Assertions.assertEquals("Abono", transaccion.getTipoTransaccion());
        Assertions.assertEquals(emisor, transaccion.getOtraCuenta());
        Assertions.assertEquals(50, transaccion.getCantidad());
    }

    @Test
    public void TransactionHistory_ShouldBeAbleToQueryToOrFromAccount()
    {
        emisor.getTransacciones().add(new Transaccion("Abono", destinatario, 100));
        emisor.getTransacciones().add(new Transaccion("Cargo", destinatario, 100));
        emisor.getTransacciones().add(new Transaccion("Abono", destinatario, 100));
        emisor.getTransacciones().add(new Transaccion("Cargo", new CuentaBancaria(3), 100));

        var transacciones = emisor.obtenerTransaccionesPorTipoYCuenta("Cargo", destinatario);
        Assertions.assertEquals(1, transacciones.size());
    }
}
