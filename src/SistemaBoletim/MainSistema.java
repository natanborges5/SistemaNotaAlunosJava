package SistemaBoletim;
import java.util.Scanner;


public class MainSistema {
    public static void main(String[] args){
        String[] alunos = new String[100];
        Float[] nota1 = new Float[100];
        Float[] nota2 = new Float[100];
        int contador = 0;
        boolean iniciar = true;
        while (iniciar){
            System.out.println("""
                1----Registrar as notas de um novo aluno.
                2----Consultar boletim de um aluno.
                3----Consultar notas da turma.
                4----Sair""");
            Scanner in = new Scanner(System.in);
            System.out.print("Selecione uma das operações:");
            int escolha = in.nextInt();
            if (escolha == 1){
                if (contador == 3){
                    System.out.println("O sistema já possui 100 alunos cadastrados!");
                }else{
                    System.out.print("Digite o nome do aluno:");
                    alunos[contador] = in.next();
                    System.out.print("Digite a AV1 do aluno:");
                    nota1[contador] = in.nextFloat();
                    System.out.print("Digite a AV2 do aluno:");
                    nota2[contador] = in.nextFloat();
                    contador ++;
                }
            }
            if (escolha == 2){
                System.out.print("Digite o numero de registro(de 0 a 99) do aluno:");
                int numeroAluno = in.nextInt();
                String nomeAluno = alunos[numeroAluno];
                float mediaAluno = (nota1[numeroAluno] + nota2[numeroAluno])/2;
                String situacao = "";
                if (mediaAluno < 4){
                    situacao = "Reprovado";
                }
                if(mediaAluno >= 4 && mediaAluno<7){
                    situacao = "Prova final";
                }
                if(mediaAluno >= 7){
                    situacao = "Aprovado";
                }
                System.out.println("O nome do aluno é: "+ nomeAluno +" nota AV1:" + nota1[numeroAluno] + " e AV2:" + nota2[numeroAluno] +
                        " com nota média de:"+ mediaAluno +" situação do aluno:"+situacao);
            }
            if (escolha == 3) {
                for (int i = 0; i <= contador - 1; i = i + 1) {
                    float mediaAluno = (nota1[i] + nota2[i])/2;
                    String situacao = "";
                    if (mediaAluno < 4){
                        situacao = "Reprovado";
                    }else if(mediaAluno >= 4 && mediaAluno<7){
                        situacao = "Prova final";
                    }else if(mediaAluno >= 7){
                        situacao = "Aprovado";
                    }
                    System.out.println("O nome do aluno é: "+ alunos[i] +" nota AV1:" + nota1[i] + " e AV2:" + nota2[i] +
                            " com nota média de:"+ mediaAluno +" situação do aluno:"+situacao);
                }
            }
            if (escolha == 4){
                iniciar = false;
            }
            if (escolha > 4){
                System.out.println("Operação invalida, tente novamente");
            }
        }
    }

}
