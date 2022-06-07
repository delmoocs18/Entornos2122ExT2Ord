import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private int numeroCuenta;
    private double balance;
    private ArrayList<Transaccion> transacciones;

    public CuentaBancaria(int accountNumber) {
        this.numeroCuenta = accountNumber;
        transacciones = new ArrayList<Transaccion>();
    }

    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public double getBalance() {
        return this.balance;
    }
    public void setBalance(int value) {
        this.balance = value;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return this.transacciones;
    }

    public final void transferir(double cantidad, CuentaBancaria destinatario) {
        double nuevoBalanceEmisor = this.balance - cantidad;
        this.balance = nuevoBalanceEmisor;

        Transaccion cargo = new Transaccion("Cargo", destinatario, cantidad);
        this.transacciones.add(cargo);

        double nuevoBalanceDestinatario = destinatario.balance + cantidad;
        destinatario.balance = nuevoBalanceDestinatario;

        Transaccion abono = new Transaccion("Abono", this, cantidad);

        ArrayList<Transaccion> transaccionesDestinatario = destinatario.getTransacciones();
        transaccionesDestinatario.add(abono);
    }

    public final ArrayList<Transaccion> obtenerTransaccionesPorTipoYCuenta(String tipoTransaccionBuscado, CuentaBancaria cuentaBancariaBuscada) {
        ArrayList<Transaccion> transaccions = new ArrayList<Transaccion>();
        for (int i = 0; i < this.transacciones.size(); i++) {
            Transaccion transaccion = this.transacciones.get(i);
            String tipoTransaccion = transaccion.getTipoTransaccion();
            CuentaBancaria otraCuenta =transaccion.getOtraCuenta();
            if (tipoTransaccion == tipoTransaccionBuscado)
            {
                if ( otraCuenta == cuentaBancariaBuscada) {
                    transaccions.add(transaccion);
                }
            }
        }
        return transaccions;
    }

    @Override
    public boolean equals(Object obj) {
        return (((CuentaBancaria)(obj)).numeroCuenta == this.numeroCuenta);
    }


}

