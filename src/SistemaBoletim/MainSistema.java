package SistemaBoletim;
import java.util.Objects;
import java.util.Scanner;


public class MainSistema {
    public static void main(String[] args){
        Domain1 dm1 = new Domain1();
        boolean iniciar = true;
        while (iniciar){
            System.out.println("""
                1----Registrar as notas de um novo aluno.
                2----Consultar boletim de um aluno.
                3----Consultar notas da turma.
                4----Sair""");
            Scanner in = new Scanner(System.in);
            System.out.print("Selecione uma das operações:");
            String escolha = in.next();
            if (Objects.equals(escolha, "1")){
                Integer limiteContador = dm1.GetContador();
                if (limiteContador == 99){
                    System.out.println("O sistema já possui 100 alunos cadastrados!");
                }else{
                    System.out.print("Digite o nome do aluno, o nome do meio e o sobrenome:");
                    String nomeAluno = in.next();
                    String nomeMeio = in.next();
                    String nomeFim = in.next();
                    String nomeCompleto = nomeAluno+" "+nomeMeio+" "+nomeFim;
                    
                    
                    System.out.print("Digite a AV1 do aluno:");
                    String notaUmString = in.next();
                    
                    System.out.print("Digite a AV2 do aluno:");
                    String notaDoisString = in.next();
                    try {
                        float notaUm = Float.parseFloat(notaUmString);
                        float notaDois = Float.parseFloat(notaDoisString);
                        if(notaUm > 10 || notaDois > 10)
                            System.out.println("As notas do alunos devem ser menores ou iguais a 10");
                        else dm1.CriarAluno(nomeCompleto,notaUm,notaDois);

                    } catch (Exception e) {
                        System.out.println("Preenchimento incorreto, o nome do aluno deve conter os 3 nomes, as notas devem ser numeros e menores que 10");
                    }
                }
            }
            else if (Objects.equals(escolha, "2")){
                System.out.print("Digite o numero de registro(de 0 a 99) do aluno:");
                String numeroAlunoString = in.next();
                try {
                    int numeroAluno = Integer.parseInt(numeroAlunoString);
                    dm1.ImprimirAluno(numeroAluno);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (Objects.equals(escolha, "3")){
                dm1.ImprimirTodos();
            }
            else if (Objects.equals(escolha, "4")){
                iniciar = false;
            } else System.out.println("Opção invalida");
        }
    }

}
