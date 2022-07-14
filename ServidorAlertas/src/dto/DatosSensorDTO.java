package dto;

public class DatosSensorDTO {
    private double frecuenciaCardiaca;
    private double tensionArterial;
    private double frecuenciaRespiratoria;
    private double temperatura;
    private double oxigeno;

    public DatosSensorDTO() { }
    public DatosSensorDTO(double frecuenciaCardiaca, double tensionArterial, double frecuenciaRespiratoria,
            double temperatura, double oxigeno) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.tensionArterial = tensionArterial;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.temperatura = temperatura;
        this.oxigeno = oxigeno;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public double getTensionArterial() {
        return tensionArterial;
    }

    public void setTensionArterial(double tensionArterial) {
        this.tensionArterial = tensionArterial;
    }

    public double getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(double frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getOxigeno() {
        return oxigeno;
    }

    public void setOxigeno(double oxigeno) {
        this.oxigeno = oxigeno;
    }
}