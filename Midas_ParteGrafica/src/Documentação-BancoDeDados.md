Classe: Usuario

Descrição:  
Essa classe irá armazenar as informações do usuário. Depois de fazer o cadastro, o controller deve armazenar os atributos recebidos nos atributos dessa classe. Além disso irá armazenar o nível de acesso do usuário(2 - ADM, 1 - autorizado, 0 - naoautorizado).
Atributos:
private String cpf;
private String nome; // Nome complete
private String endereco;
private String profissao;
private String senha;
private String email; 
private char sexo;
private int nivelDeAcesso;
Métodos: 
Gets e Sets desse atributos.

Classe: UsuarioDAO

Descrição: 
Essa classe conterá os métodos que ligaram a classe Usuário com a tabela do banco de dados.
Métodos:
public static void comecarOperacoes();
Descrição: Para a realização das operações abaixo é necessário que primeiro esse método tem sido executado. Esse método irá iniciar a conexão com banco de dados.
public static void finalizarOperacoes();
Descrição: Depois de fazer as operações, executar esse método para fechar a conexão com o banco.
public boolean inserir(Usuario usuario); 
Descrição: Esse método irá inserir todos as informações do usuário na tabela referente à classe usuario no banco de dados. No banco só poderá existir um único usuario com determinado cpf. Se o usuario inserir pela segunda vez uma classe usuario com a mesmo cpf, a função retornará que a operação foi mal sucedida.
Parâmetros: 
usuario - uma intância da classe usuário com todas as informações preenchidas, até o nível de acesso do usuário.
Retorno: Se a operação foi um sucesso, retorna verdadeiro. Se a operação foi um fracasso, retorna falso.
public boolean remover(String cpf_usuario);
Descrição:  Esse método irá procurar o usuário no banco de dados, se existir, então esse usuario será removido do banco.
Parâmetros:
cpf_usuario - A string que servirá para achar o usuario para poder remover. Para este método funcionar é necessário que o campo cpf de todos usuário estejam preenchidos.
Retorno: Se o usuario existir, irá removê-lo e o método  retornará verdadeiro. Se o usuario não exitir, o método retornará falso.
public List<Usuario> listarNaoAutorizado();
Descrição: Esse método irá recuperar do banco de dados uma lista com todos os usuários que não tiveram seu cadastro autorizado.
Retorno: 	O retorno sera uma lista com todos os usuarios que ainda não foram autorizados e suas informações.
public Boolean autorizar(String cpf_usuario);
Descrição: Esse método irá atualizar o campo NíveldeAcesso de determinado usuario com o cpf igual à cpf_usuario. Se esse usurio não existir a operação fracassou. O metodo irá mudar a flag de 0 (não autorizado) para 1 (autorizado). Ele irá retornar um valor correspondente ao resultado da operação.
Parâmetros: 
cpf_usuario - A string que servirá para achar o usuario para poder atulizar o campo nível de acesso. Para este método funcionar é necessário que o campo cpf de todos usuário estejam preenchidos.
Retorno: Se o usuario existe, o usuario será autorizado e o método retornará true. Se ele não existir,  o método retornará false.
public Usuario recuperar(String cpf_usuario);
Descrição:  Esse método irá procurar um usuário no banco de dados com o cpf recebido como  parâmetro.
Parâmetros:
cpf_usuario - A String que servirá para achar o usuário.
Retorno: Se o usuario existir, a função retornará uma instancia da classe usuario com todas as informações contidas no banco de dados, inclusive senha e níveldeAcesso. Se o usuario não existir a função irá lançar um exceção.
Exceção:  Talvez seja SQLException. Quase certeza.
Public Boolean login (String cpf_usuario, String senha);
	Descrição: Esse método irá procurar a senha do usuario com o cpf_usuario e verificar se a senha é igual a senha recebida como parametro String senha.
	Parâmetros:
	Cpf_usuario – A string que servirá para achar o usuário (chave primária)
	Retorno: Se a senha que está no banco de dados do usuario que possui o cpf_usuario de parametro for igual a senha inserida como parametro, o retorno é true. Caso contrario, o retorno sera false.

public boolean verificaExisteUsuario(String cpf_usuario);
	Descrição: Esse método irá procurar se já existe um usuario com o cpf_usuario inserido como parametro e deve ser chamado antes de fazer o cadastro do usuario.
	Parâmetros:
	Cpf_usuario – A string que servirá para procurar o usuário (chave primária)
	Retorno: Se o usuário ja existe retorna true. Se o cpf_usuario não existe no banco de dados, retorna false;
Classe: Mammogram

	Descrição: Essa classe irá armazenar as informações do exame de mamas. Ao fazer o login, o controller deverá chamar essa função para que apareça na tela os exames.
	Parametros:
	private int mammogramId;
	private byte[] imagem;
	Metodos:
	Gets e Sets	
	public BufferedImage converte(byte[] vetorByte)
	Descrição: Esse método converte uma matriz de bytes para uma BufferedImage, para que ela seja lida e mostrada na tela com a interface gráfica.
	Parametros:
	Byte[] vetor byte: vetor de bytes com as informações da imagem que estão armazenadas no banco de dados.
	Retorno:
	BufferedImage: é usado uma função ImageIo.Read da biblioteca:
import java.awt.image.BufferedImage;
para fazer a conversão de dados;

Classe: MammogramDAO

Descrição:
Essa classe irá exibir a imagem do exame escolhido pelo usuário após a busca.
Atributos: Nenhum
Metodos:
public Mammogram recuperar(int mamoId);
Descrição: 
O método deverá recuperar uma imagem a partir de sua chave primaria mamoID.
Parametros:
Um inteiro com a chave primária da mamografia a ser recuperada;
Retorno:
A classe Mammogram que possui o atributo de mamoID e a imagem em forma de matriz de bits.

public boolean inserir();
Descrição:
O método deverá inserir no banco de dados uma imagem com o path específico da imagem.
Parametros:
Nenhum.
Retorno:
Ela irá retornar true se a imagem foi inserida com sucesso e false caso contrario.

