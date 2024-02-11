public class Main {
    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9-_]+$";

    public static void main(String[] args) {
        check("aregfvb", "sdfrg34gf", "sdfrg34gf");
        check("sghjbfdgjkhsbnjvndfrokgm", "sdfrg34gf", "sdfrg34gf");
        check("rsfgfdved", "sdfrg3erg4gf", "sdfrg34gf");
        check("hgfdhbrtdh", "sdfrg34gf#", "sdfrg34gf#");
        check("dfsbrsbg", "sdfrg34gfsfvsdfvasdzvc", "sdfrg34gfsfvsdfvasdzvc");
    }

    private static void check(String login, String pass, String confirmPass) {
        try {
            checkLogin(login);
            checkPass(pass, confirmPass);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка с введеныым логином: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка с введеныым паролем: " + e.getMessage());
        }
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)){
            throw new WrongLoginException("Логин может содержать в себе только буквы, цивры и знак подчеркивания");
        }

        if (login.length() > 20){
            throw new WrongLoginException("Логин не может быть длинее 20 символов");
        }
    }
    private static void checkPass(String pass, String confirmPass) throws WrongPasswordException {
        if (!pass.matches(VALIDATE_PATTERN)){
            throw new WrongPasswordException("пароль может содержать в себе только буквы, цивры и знак подчеркивания");
        }

        if (pass.length() > 20){
            throw new WrongPasswordException("Пароль не может быть длинее 20 символов");
        }

        if (!pass.equals(confirmPass)){
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
