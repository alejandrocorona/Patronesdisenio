package mx.edu.utng.acp.patronesdisenio;

/**
 * Created by ACP on 15/04/2016.
 */
public class PrototipoImagen extends Imagen implements Clonar{

    @Override
    public Object clonar() {
        // TODO Auto-generated method stub
        Imagen img  = new Imagen();

        img.setNombre(this.getNombre());
        return img;
    }
}
