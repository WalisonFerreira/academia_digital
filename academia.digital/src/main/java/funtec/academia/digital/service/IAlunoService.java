package funtec.academia.digital.service;

import funtec.academia.digital.model.Aluno;
import funtec.academia.digital.model.AvaliacaoFisica;
import funtec.academia.digital.model.form.AlunoForm;
import funtec.academia.digital.model.form.AlunoUpdateForm;
import funtec.academia.digital.service.impl.AlunoServiceImpl;

import java.time.LocalDate;
import java.util.List;

public interface IAlunoService {
	
  Aluno create(AlunoForm form);

  Aluno get(Long id);
  
  List<Aluno> getAll(String dataDeNascimento);

  Aluno update(Long id, AlunoUpdateForm formUpdate);

  void delete(Long id);

  List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);

}