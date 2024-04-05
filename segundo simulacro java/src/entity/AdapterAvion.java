package entity;

public class AdapterAvion {
    //solo necesitas crear este archivo en caso de que quieras mostrar un dato específico
    //de una entidad ajena dentro de un controlador de otra entidad
    //ESTO SE USA PARA EL CREATE

    private Avion avion;

    public AdapterAvion(Avion avion) {
        this.avion = avion;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return avion.getModelo();
    }
}
