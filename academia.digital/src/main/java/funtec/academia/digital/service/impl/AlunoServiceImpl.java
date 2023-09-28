package funtec.academia.digital.service.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import funtec.academia.digital.infra.untils.JavaTimeUtils;
import funtec.academia.digital.model.Aluno;
import funtec.academia.digital.model.form.AlunoForm;
import funtec.academia.digital.model.form.AlunoUpdateForm;
import funtec.academia.digital.repository.AlunoRepository;
import funtec.academia.digital.service.IAlunoService;
import funtec.academia.digital.model.AvaliacaoFisica;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Service
public class AlunoServiceImpl implements IAlunoService {

  @Autowired
  private AlunoRepository repository;

  @Override
  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    formatter = formatter.withLocale(Locale.US);  // Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
    LocalDate date = LocalDate.parse(form.getDataDeNascimento(), formatter);
    aluno.setDataDeNascimento(date);

    return repository.save(aluno);
  }

  @Override
  public Aluno get(Long id) {
    return null;
  }

  @Override
  public List<Aluno> getAll(String dataDeNascimento) {

    if(dataDeNascimento == null) {
      return repository.findAll();
    } else {
      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
      return repository.findByDataDeNascimento(localDate);
    }

  }

  @Override
  public Aluno update(Long id, AlunoUpdateForm formUpdate) {
    return null;
  }

  @Override
  public void delete(Long id) {
  }

  @Override
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {

    Aluno aluno = repository.findById(id).get();

    return aluno.getAvaliacoes();

  }

}