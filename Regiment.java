public class Regiment {
	private int	gunmen, snipers, artilleries, medics, tanks;

	private int x, y;

	public Regiment(int x, int y) {
		setPosition(x, y);

		gunmen = 0;
		snipers = 0;
		artilleries = 0;
		medics = 0;
		tanks = 0;
	}

	public void addTroops(int type, int amount) {
		if (type == 0) {
			gunmen += amount;
		} else if (type == 1) {
			snipers += amount;
		} else if (type == 2) {
			artilleries += amount;
		} else if (type == 3) {
			medics += amount;
		} else if (type == 4) {
			tanks += amount;
		}
	}

	public boolean removeTroops(int type, int amount) {
		if (type == 0) {
			if (gunmen < amount) {
				return false;
			}
			gunmen -= amount;
		} else if (type == 1) {
			if (snipers < amount) {
				return false;
			}
			snipers -= amount;
		} else if (type == 2) {
			if (artilleries < amount) {
				return false;
			}
			artilleries -= amount;
		} else if (type == 3) {
			if (medics < amount) {
				return false;
			}
			medics -= amount;
		} else if (type == 4) {
			if (tanks < amount) {
				return false;
			}
			tanks -= amount;
		}
		return true;
	}

	public void move(int x, int y) {
		// check
		setPosition(x, y);
	}

	private void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
}