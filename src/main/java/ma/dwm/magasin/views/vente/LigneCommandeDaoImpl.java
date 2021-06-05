/*
 * package ma.dwm.magasin.views.vente;
 * 
 * import java.sql.Date; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import connection.AbstractDAO; import javafx.scene.control.Label; import
 * javafx.stage.Stage; import ma.dwm.magasin.views.application.ListeClients;
 * import ma.dwm.magasin.views.application.Main; import
 * ma.dwm.magasin.views.client.Client; import
 * ma.dwm.magasin.views.produit.Produit;
 * 
 * public class LigneCommandeDaoImpl extends AbstractDAO implements
 * ILigneCommandeDAO{
 * 
 * @Override public void add(LigneCommande obj) {
 * 
 * PreparedStatement pst=null; String
 * query="insert into lignecommande (designation,prix,qte,sous_total,id_produit,id_vente)values(?,?,?,?,?,?)"
 * ;
 * 
 * try {
 * 
 * pst=connection.prepareStatement(query); pst.setString(1,
 * obj.getDesignation()); pst.setDouble(2, obj.getPrix());
 * pst.setInt(3,obj.getQte()); pst.setDouble(4, obj.getSous_total());
 * pst.setLong(5, obj.getId_produit()); pst.setLong(6, obj.getId_vente());
 * pst.executeUpdate();
 * 
 * } catch (SQLException e) {
 * 
 * e.printStackTrace(); }
 * 
 * }
 * 
 * @Override public void update(LigneCommande obj) { PreparedStatement pst=null;
 * String
 * query="UPDATE lignecommande set designation=?,prix=?, qte=?,sous_total=?,id_produit=? WHERE id_cmd=?"
 * ;
 * 
 * try {
 * 
 * pst=connection.prepareStatement(query);
 * pst.setString(1,obj.getDesignation()); pst.setDouble(2, obj.getPrix());
 * pst.setInt(3,obj.getQte()); pst.setDouble(4, obj.getSous_total());
 * pst.setLong(5, obj.getId_produit()); pst.setLong(6, obj.getId_commande());
 * pst.executeUpdate();
 * 
 * } catch (SQLException e) {
 * 
 * e.printStackTrace(); }
 * 
 * }
 * 
 * @Override public void delete(long id) { PreparedStatement pst=null; ResultSet
 * rs; String query="delete from lignecommande where id_cmd =?";
 * 
 * try {
 * 
 * pst=connection.prepareStatement(query); pst.setLong(1, id);
 * pst.executeUpdate();
 * 
 * } catch (SQLException e) {
 * 
 * e.printStackTrace(); }
 * 
 * }
 * 
 * @Override public LigneCommande getOne(long id) { List<LigneCommande> list
 * =new ArrayList<LigneCommande>(); PreparedStatement pst=null; ResultSet rs;
 * String query="select * from lignecommande where id_cmd =?";
 * 
 * try {
 * 
 * pst=connection.prepareStatement(query); pst.setLong(1, id);
 * rs=pst.executeQuery(); if(rs.next()) { return new
 * LigneCommande(rs.getLong("id_cmd"),rs.getString("designation"),rs.getDouble(
 * "prix"),rs.getInt("qte"),rs.getDouble("sous_total"),rs.getLong("id_produit"),
 * rs.getLong("id_vente")); }
 * 
 * } catch (SQLException e) {
 * 
 * e.printStackTrace(); }
 * 
 * return null; }
 * 
 * @Override public List<LigneCommande> getAll(){ return null;
 * 
 * }
 * 
 * 
 * public List<LigneCommande> getAllLigne(long id_vente) { List<LigneCommande>
 * list =new ArrayList<LigneCommande>(); PreparedStatement pst=null; ResultSet
 * rs; String query="select * from lignecommande where id_vente=?";
 * 
 * try {
 * 
 * pst=connection.prepareStatement(query); pst.setLong(1, id_vente);
 * rs=pst.executeQuery(); while(rs.next()) { list.add(new
 * LigneCommande(rs.getLong("id_cmd"),rs.getString("designation"),rs.getDouble(
 * "prix"),rs.getInt("qte"),rs.getDouble("sous_total"),rs.getLong("id_produit"),
 * rs.getLong("id_vente"))); }
 * 
 * } catch (SQLException e) {
 * 
 * e.printStackTrace(); }
 * 
 * return list; }
 * 
 * @Override public List<LigneCommande> getAll(String text) {
 * List<LigneCommande> list =new ArrayList<LigneCommande>(); PreparedStatement
 * pst=null; ResultSet rs; String
 * query="select * from lignecommande where designation like ?";
 * 
 * try {
 * 
 * pst=connection.prepareStatement(query); pst.setString(1, text+"%");
 * rs=pst.executeQuery(); while(rs.next()) { list.add(new
 * LigneCommande(rs.getLong("id_cmd"),rs.getString("designation"),rs.getDouble(
 * "prix"),rs.getInt("qte"),rs.getDouble("sous_total"),rs.getLong("id_produit"),
 * rs.getLong("id_vente"))); }
 * 
 * } catch (SQLException e) {
 * 
 * e.printStackTrace(); }
 * 
 * return list; }
 * 
 * 
 * 
 * }
 */