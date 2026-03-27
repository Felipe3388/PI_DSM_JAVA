package Model;

public class Validador {

    // Exemplo 1: Validando o Código do Cliente
    public static boolean isCodigoClienteValido(String codigoStr) {
        if (codigoStr == null || codigoStr.trim().isEmpty()) {
            return false; // Não pode ser vazio
        }
        
        try {
            int codigo = Integer.parseInt(codigoStr);
            return codigo > 0; // O código deve ser um número positivo
        } catch (NumberFormatException e) {
            return false; // Falha se o usuário digitar letras no lugar do código
        }
    }

    // Exemplo 2: Estrutura para validar o CPF
    public static boolean isCpfValido(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return false;
        }
        
        // Remove pontos e traços (ex: de "111.222.333-44" para "11122233344")
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Aqui entraria a lógica matemática para calcular os dois dígitos verificadores do CPF...
        
        return true; 
    }
}