import java.util.ArrayList;

public class Regiment {
	private ArrayList<Gunman> gunmen;
	private ArrayList<Sniper> snipers;
	private ArrayList<Artillery> artilleries;
	private ArrayList<Medic> medics;
	private ArrayList<Tank> tanks;

	private int x, y;

	public Regiment(int x, int y) {
		setPosition(x, y);

		gunmen = new ArrayList<Gunman>();
		snipers = new ArrayList<Sniper>();
		artilleries = new ArrayList<Artillery>();
		medics = new ArrayList<Medic>();
		tanks = new ArrayList<Tank>();
	}

	public void addGunman(Gunman unit) {
		gunmen.add(unit);
	}

	public void addSniper(Sniper unit) {
		snipers.add(unit);
	}

	public void addArtillery(Artillery unit) {
		artilleries.add(unit);
	}

	public void addMedic(Medic unit) {
		medics.add(unit);
	}

	public void addTank(Tank unit) {
		tanks.add(unit);
	}

	/**
	 * @TODO: better way of removing troops from regiments
	 */
	public boolean removeTroops(int type, int index) {
		if (type == 0) {
			if (gunmen.size() <= index) {
				return false;
			}
			gunmen.remove(index);
		} else if (type == 1) {
			if (snipers.size() <= index) {
				return false;
			}
			snipers.remove(index);
		} else if (type == 2) {
			if (artilleries.size() <= index) {
				return false;
			}
			artilleries.remove(index);
		} else if (type == 3) {
			if (medics.size() <= index) {
				return false;
			}
			medics.remove(index);
		} else if (type == 4) {
			if (tanks.size() <= index) {
				return false;
			}
			tanks.remove(index);
		}
		return true;
	}

	public void move(int addX, int addY) {
		// check if valid movement
		setPosition(x + addX, y + addY);
	}

	private void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}