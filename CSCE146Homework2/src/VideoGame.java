/*
 * Brently George
 */
public class VideoGame {
	private String name;
	private String console;
	
	public VideoGame() {
		this.name = "noname";
		this.console = "noconsole";
	}
	
	public VideoGame(String name, String console) {
		this.setName(name);
		this.setConsole(console);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null)
			this.name = name;
		else
			this.name = "noname";
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		if (console != null)
			this.console = console;
		else
			this.console = "noconsole";
	}

	//TODO update this?
	public String toString() {
		return "VideoGame [name=" + name + ", console=" + console + "]";
	}
	
	public boolean equals(VideoGame game) {
		return game != null &&
				this.name.equals(game.getName()) &&
				this.console.equals(game.getConsole());
	}
}
