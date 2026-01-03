package practicaObligatoria.Modelos;

public class Transaccion {
    private double precioFinal;
    private String emailSocio;
    private int puntuacion;
    private String comentario;
    private String fecha;

    public Transaccion(double precioFinal, String emailSocio, int puntuacion, String comentario, String fecha) {
        this.precioFinal = precioFinal;
        this.emailSocio = emailSocio;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public String getEmailSocio() {
        return emailSocio;
    }

    public void setEmailSocio(String emailSocio) {
        this.emailSocio = emailSocio;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format(
                "  > Fecha: %s\n" +
                        "  > Precio Final: %.2f€\n" +
                        "  > Socio Involucrado (Email): %s\n" +
                        "  > Puntuación Recibida: %d/5\n" +
                        "  > Comentario: \"%s\"",
                fecha, precioFinal, emailSocio, puntuacion, comentario
        );
    }
}
