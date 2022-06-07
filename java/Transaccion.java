public class Transaccion {
    private String tipoTransaccion;
    private CuentaBancaria otraCuenta;
    private double cantidad;

    public Transaccion(String tipoTransaccion, CuentaBancaria otraCuenta, double cantidad) {
        this.tipoTransaccion = tipoTransaccion;
        this.otraCuenta = otraCuenta;
        this.cantidad = cantidad;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public CuentaBancaria getOtraCuenta() {
        return otraCuenta;
    }

    public double getCantidad() {
        return cantidad;
    }
}
