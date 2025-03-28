package gm.tareas.servicio;

import gm.tareas.modelo.Tarea;
import gm.tareas.repositorio.ITareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio implements ITareaServicio{

    @Autowired
    private ITareaRepositorio tareaRepositorio;

    @Override
    public List<Tarea> listarTareas(){
        List<Tarea> tareas = tareaRepositorio.findAll();
        return tareas;
    }

    @Override
    public Tarea buscarTareaPorId(Integer idTarea){
        Tarea tarea = tareaRepositorio.findById(idTarea).orElse(null);
        return tarea;
    }

    @Override
    public void guardarTarea(Tarea tarea){
        tareaRepositorio.save(tarea);
    }

    @Override
    public void eliminarTarea(Tarea tarea){
        tareaRepositorio.delete(tarea);
    }

}
