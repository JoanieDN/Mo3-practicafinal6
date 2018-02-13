
package com.example.demo.services.impl;

import com.example.demo.domain.Turno;
import com.example.demo.repository.TurnoRepository;
import com.example.demo.services.TurnoService;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Component
@Service
@Transactional
public class TurnoServiceImpl  implements TurnoService{
    
    private final TurnoRepository turnoRepository;

    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    
    @Override
    public void save(Turno turno) {
          turnoRepository.save(turno);
    }

    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    @Override
    public List<Turno> RangoFechas(Date fechaInicio, Date fechaFin) {
        return turnoRepository.RangoFechas(fechaInicio, fechaFin);
    }

    @Override
    public List<Turno> BuscarFecha(Date fecha) {
       return turnoRepository.BuscarFecha(fecha);
    }

    @Override
    public List<Turno> FechaObraSocial(Date fecha) {
      return turnoRepository.FechaObraSocial(fecha);
    }

    @Override
    public List<Turno> ExistenciaTurno(Long id, Date fecha) {
       return turnoRepository.ExistenciaTurno(id, fecha);
    }
}
