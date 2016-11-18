import java.util.*;
import java.util.stream.Collectors;

public class SeguridadSocial{

    private Map <String, Persona> MapDNI = new HashMap();
    private Map <String, Persona> MapSS = new HashMap();



    public void altaPersona(Persona persona) {
        if(!MapDNI.containsKey(persona.getDNI()) && !MapSS.containsKey(persona.getNumSS())){
            MapDNI.put(persona.getDNI(), persona);
            MapSS.put(persona.getNumSS(), persona);
        }
    }
    public void bajaPersona(String dni) {
        if(MapDNI.containsKey(dni)){
            MapSS.remove(MapDNI.get(dni).getNumSS());
            MapDNI.remove(dni);
        }
    }
    public Persona obtenerPersonaPorDNI(String dni) {
        return MapDNI.get(dni);
    }
    public Persona obtenerPersonaPorNumSS(String numSS) {
        return MapSS.get(numSS);
    }
    public List<Persona> obtenerPersonasRangoSalarial(double min, double max){

         List<Persona> aux=new ArrayList<>();
            for(Persona persona: MapDNI.values()){
                if(persona.getSalario()>=min && persona.getSalario()<=max){
                    aux.add(persona);
                }
            }
            return aux;
    }
    public Persona obtenerPersonaSalarioMax(){
        return MapDNI.values().stream().max(Comparator.comparing(Persona::getSalario)).get();
    }
    public Persona obtenerPersonaSalarioMin(){
        return MapDNI.values().stream().min(Comparator.comparing(Persona::getSalario)).get();
    }
    public List<Persona> obtenerPersonasMayoresQue(int edad){
        return MapDNI.values().stream().filter(persona -> persona.getEdad()>edad).collect(Collectors.toList());
    }
    public List<Persona> obtenerTodas(){
        return new ArrayList<>(MapDNI.values());
    }
}