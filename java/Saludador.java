public class Saludador {

    private boolean gritar;

    public String saludar(String nombre) {
        gritar = false;
        String respuesta = "Hola, ";
        if (nombre == null) {
            respuesta += "amigo mio";
        } else {
            respuesta += nombre;
        }
        if (nombre!=null && nombre == nombre.toUpperCase()) {
            gritar = true;
        }
        return responder(respuesta);
    }

    public String saludar(String[] nombres) {
        String respuesta = "Hola";
        for (int i = 0; i < nombres.length; i++) {
            if (i==nombres.length-1) {
                respuesta += " y " + nombres[i];
            } else{
                respuesta += ", "+ nombres[i];
            }
        }
        return responder(respuesta);
    }

    private String responder(String respuesta){
        if (gritar)
            return respuesta.toUpperCase() + "!";
        return respuesta+ ".";
    }

}
