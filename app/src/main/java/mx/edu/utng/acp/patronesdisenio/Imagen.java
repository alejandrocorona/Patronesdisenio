package mx.edu.utng.acp.patronesdisenio;

/**
 * Created by ACP on 15/04/2016.
 */
public class Imagen {

        private static Imagen img;
    private String nombre;
    private String tamanio;


        public Imagen() {
            // TODO Auto-generated constructor stub
            this.nombre = "FLOR";
            this.tamanio = "Chico";
        }


        public static Imagen getImagen(){
            //Crear solo un objeto imagen
            if(img == null){
                img = new Imagen();
            }
            return img;
        }
        public static void setImagen(Imagen img) {
            Imagen.img = img;
        }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public static Imagen getImg() {
        return img;
    }

    public static void setImg(Imagen img) {
        Imagen.img = img;
    }
}
