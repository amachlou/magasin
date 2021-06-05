package ma.dwm.magasin.views.login;

public interface ILoginDAO<Login> {

	public Login getOne(String user,String password);
}
