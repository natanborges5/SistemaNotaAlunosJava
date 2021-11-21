package SistemaBoletim;

public class Domain1 {
    private String nomeAluno;
    private String nomeMeioAluno;
    private String nomeFinalAluno;
    private String nomeProfessor;
    private String nomeMeioProfessor;
    private String nomeFinalProfessor;

    String[] alunos = new String[100];
    Float[] nota1 = new Float[100];
    Float[] nota2 = new Float[100];
    int contador = 0;
    public String getNome() {
        return nomeAluno;
    }
    public void ImprimirAluno(Integer numeroAluno) throws Exception {
        String nomeAluno = alunos[numeroAluno];
        if (nomeAluno == null){
            throw new Exception("Não existe um aluno com esse registro ou não existe nenhum aluno cadastrado");
        }
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
        StringBuilder sb = new StringBuilder();
        sb.append("O nome do aluno é: ").append(nomeAluno).append(" nota AV1:").append(nota1[numeroAluno]).append(" e AV2:").append(nota2[numeroAluno])
                .append(" com nota média de:").append(mediaAluno).append(" situação do aluno:").append(situacao);
        System.out.println(sb.toString());
    }
    public void CriarProfessor(String nome){
        String[] nomes = nome.split(" ");
        String primeiroNome = nomes[0];
        String segundoNome = nomes[1];
        String terceiroNome = nomes[2];
        System.out.print(primeiroNome);
        System.out.print(segundoNome);
        System.out.print(terceiroNome);
    }

    public void CriarAluno(String nome,Float notaUm,Float notaDois) throws Exception {
        int posIni = nome.indexOf(" ");
        int posFim = nome.lastIndexOf(" ");
        this.nomeAluno = nome.substring(0,posIni);
        this.nomeMeioAluno = nome.substring(posIni,posFim).trim();
        this.nomeFinalAluno = nome.substring(posFim).trim();

        alunos[contador] = nome;
        nota1[contador] = notaUm;
        nota2[contador] = notaDois;
        contador++;
    }
    public void ImprimirTodos(){
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
            StringBuilder sb = new StringBuilder();
            sb.append("O nome do aluno é: ").append(alunos[i]).append(" nota AV1:").append(nota1[i]).append(" e AV2:").append(nota2[i])
                    .append(" com nota média de:").append(mediaAluno).append(" situação do aluno:").append(situacao);

            System.out.println(sb.toString());
        }
    }
    public Integer GetContador(){
        return contador;
    }
}
