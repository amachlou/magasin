package ma.dwm.magasin.views.user;

public interface ILoginDAO<Login> {

	public Login getOne(String user,String password);
}
