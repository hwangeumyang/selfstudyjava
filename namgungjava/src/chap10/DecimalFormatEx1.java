package chap10;

import java.text.*;

public class DecimalFormatEx1 {
	public static void main(String [] args) throws Exception {
		double number = 1234567.89;
		String [] pat = {
				"0",
				"#",
				"0.0",
				"#.#",
				"00000000000.0000",
				"###########.####",
				"#.#-",
				"-#.#",
				"#,###.##",
				"#,####.##",
				"#E0",
				"0E0",
				"##E0",
				"00E0",
				"####E0",
				"0000E0",
				"#.#E0",
				"0.0E0",
				"0.000000000E0",
				"00.00000000E0",
				"000.0000000E0",
				"#.#########E0",
				"##.########E0",
				"###.#######E0",
				"#,###.##+;#,###.##-",
				"#.#%",
				"#.#\u2030",
				"\u00A4 #,###",
				"'#'#,###",
				"''#,###"
				
				
		};
		
		for(String p : pat) {
			DecimalFormat df = new DecimalFormat(p);
			System.out.printf("%19s : %s\n", p, df.format(number));
		}
		
	}
}
