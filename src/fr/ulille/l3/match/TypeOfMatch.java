package fr.ulille.l3.match;

public enum TypeOfMatch {
		BasicMatch("BasicMatch","Un match basique, le vainqueur est déterminé aléatoirement");
		
		private final String label;
		private final String description;

		private TypeOfMatch(String label,String description) {
			this.label = label;
			this.description = description;
		}

		public String getLabel() {
			return this.label.toLowerCase();
		}

		public static boolean contains(String lowerCase) {
			for(int i = 0; i < values().length; i++) {
				if(lowerCase.equals(values()[i].getLabel())) {
					return true;
				}
			}
			return false;
		}

		public String getDescription() {
			return this.description;
		}
	}
