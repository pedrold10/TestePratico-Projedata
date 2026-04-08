package com.testepratico;

import com.testepratico.entities.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args )
    {

        // 3.1 - Inserir todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria",   LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João",    LocalDate.of(1990, 5,  12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio",    LocalDate.of(1961, 5,  2),  new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel",  LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"),"Diretor"));
        funcionarios.add(new Funcionario("Alice",   LocalDate.of(1995, 1,  5),  new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor",  LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur",  LocalDate.of(1993, 3,  31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura",   LocalDate.of(1994, 7,  8),  new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5,  24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena",  LocalDate.of(1996, 9,  2),  new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover o funcionário "João"
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        // 3.3 - Imprimir todos os funcionários formatados
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        System.out.println("=== Lista de Funcionários ===");
        for (Funcionario f : funcionarios) {
            System.out.println(
                    "Nome: " + f.getNome() +
                            " | Data Nascimento: " + f.getDataNascimento().format(formatter) +
                            " | Salário: R$ " + nf.format(f.getSalario()) +
                            " | Função: " + f.getFuncao()
            );
        }

        // 3.4 - Aumento de 10% no salário
        funcionarios.forEach(f ->
                f.setSalario(f.getSalario().multiply(new BigDecimal("1.10")).setScale(2, RoundingMode.HALF_UP))
        );

        System.out.println("\n=== Salários após aumento de 10% ===");
        for (Funcionario f : funcionarios) {
            System.out.println(
                    "Nome: " + f.getNome() +
                            " | Novo Salário: R$ " + nf.format(f.getSalario())
            );
        }

        // 3.5 - Agrupar funcionários por função em um Map
        Map<String, List<Funcionario>> porFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }
}
