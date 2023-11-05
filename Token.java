 abstract class Token {

 protected String getTabs(int t) {
     StringBuilder tabs = new StringBuilder();
     for (int i = 0; i < t; i++) {
         tabs.append("\t");
     }
     return tabs.toString();
 }


  public String toString(int t)
  {
  	return "";
  }
}
