package partida;

public class Reloj {
	private static Reloj r = new Reloj(); 
	
	private Reloj() {
		
	}
	
	public static Reloj getReloj() {return r;}
	
	public void esperar(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
