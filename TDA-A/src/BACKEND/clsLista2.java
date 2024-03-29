
package BACKEND;


public class clsLista2 {
    private clsEstudiante ptrInicio, ptrFinal;   
    
    public clsLista2() {
         ptrInicio = null;
         ptrFinal = null;
    }
    
     public boolean ListaVacia(){
        boolean Resp = false;
        if(ptrInicio == null){
            Resp = true;
        }
        return Resp;
    } 
    
    public void Insertar(int pclave, String pnombre, String pfecha, String pcorreo, String pdireccion, int pgrado, String pseccion){
        /*Creación del nodo*/
        clsEstudiante objEstudiante = new clsEstudiante();
        objEstudiante.clave = pclave; 
        objEstudiante.nombre = pnombre; //DATOS
        objEstudiante.fecha = pfecha;
        objEstudiante.correo = pcorreo;
        objEstudiante.direccion = pdireccion;
         objEstudiante.grado = pgrado;
        objEstudiante.seccion = pseccion;
        
        objEstudiante.ptrArriba = null;
        objEstudiante.ptrAbajo = null;
        boolean Salir = false;
        
        if(ListaVacia()==true){  // Lista Vacia
            ptrInicio = objEstudiante;
            ptrFinal = objEstudiante;
        }else{  //La lista tiene registros 
            clsEstudiante ptrAuxSig = ptrInicio;
            clsEstudiante ptrAuxAnt = null;
        
            while(ptrAuxSig!= null  && Salir == false){
                
                if(ptrAuxSig.clave < pclave ){
                    ptrAuxAnt = ptrAuxSig;  //SACO COPIA
                    ptrAuxSig = ptrAuxSig.ptrAbajo;
                }else
                
                {
                    if(ptrAuxSig == ptrInicio){  //VALIDO SI ES EL INICIO DE LA LISTA
                        objEstudiante.ptrAbajo = ptrAuxSig;
                        ptrAuxSig.ptrArriba = objEstudiante;
                        ptrInicio = objEstudiante;
                        Salir = true;
                    }else{
                        objEstudiante.ptrAbajo = ptrAuxSig;
                        objEstudiante.ptrArriba = ptrAuxAnt;
                        ptrAuxAnt.ptrAbajo = objEstudiante;
                        ptrAuxSig.ptrArriba = objEstudiante;
                        Salir = true;
                    }
                }
            }  
            if(ptrAuxAnt==ptrFinal){  // El codigo del nodo es superior a todos los de la lista
                objEstudiante.ptrArriba = ptrAuxAnt;
                ptrAuxAnt.ptrAbajo = objEstudiante;
                ptrFinal = objEstudiante;
            }
        }    
     }
    
    public int ExtraerCola(){
        int Resp = 0;
     /*   if(!ListaVacia()){
            Resp = ptrInicio.Valor;
            if(ptrInicio == ptrFinal){
                ptrInicio = null;
                ptrFinal = null;
            }else{
                ptrInicio = ptrInicio.ptrSiguiente;
            }
        }
         */
        return Resp;
    }    
    
    public String Mostrar(){
        String Resp = "";
        String ES  = "";
        clsEstudiante objEstudiante = ptrInicio;
        while(objEstudiante!= null){
            //System.out.println(String.valueOf(objEstudiante.codigo));
            if(Resp.equals("")){
                Resp = String.valueOf(objEstudiante.clave) + "-"+ String.valueOf(objEstudiante.nombre) + "-" +  String.valueOf(objEstudiante.fecha)+ "-" +  String.valueOf(objEstudiante.correo)+ "-" +  String.valueOf(objEstudiante.direccion)+ "-" +  String.valueOf(objEstudiante.grado)+ "-" +  String.valueOf(objEstudiante.seccion) ;           
            }else{
           
                Resp = Resp + "     " + String.valueOf(objEstudiante.clave) + "-"+ String.valueOf(objEstudiante.nombre) + "-" +  String.valueOf(objEstudiante.fecha)+ "-" +  String.valueOf(objEstudiante.correo)+ "-" +  String.valueOf(objEstudiante.direccion)+ "-" +  String.valueOf(objEstudiante.grado)+ "-" +  String.valueOf(objEstudiante.seccion);
            }
            objEstudiante = objEstudiante.ptrAbajo;
        }
        return Resp;
    }
    
    
    public String MostrarInverso(){
        String Resp ="";
        clsEstudiante objEstudiante = ptrFinal;
        while(objEstudiante!= null){
            if(Resp.equals("")){
                Resp = String.valueOf(objEstudiante.clave);           
            }else{
                Resp = Resp + ", " + String.valueOf(objEstudiante.clave);
            }
            objEstudiante = objEstudiante.ptrArriba;
        }
        return Resp;
    }
    
}
