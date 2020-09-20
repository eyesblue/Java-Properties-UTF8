

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Enumeration;

public class Props extends java.util.Properties {

	@Override
	public void store(OutputStream out, String comments) throws IOException {
		store(new BufferedWriter(new OutputStreamWriter(out, "UTF-8")), comments);
	}

	public void store(BufferedWriter bw, String comments) throws IOException {
		// BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));

		if (comments != null) {
			writeComments(bw, comments);
		}

		bw.write("#" + new Date().toString());

		bw.newLine();

		synchronized (this) {

			for (Enumeration<?> e = keys(); e.hasMoreElements();) {

				String key = (String) e.nextElement();

				String val = (String) get(key);

				// key = saveConvert(key, true, escUnicode);

				/*
				 * No need to escape embedded and trailing spaces for value, hence
				 * 
				 * pass false to flag.
				 * 
				 */

				// val = saveConvert(val, false, escUnicode);

				bw.write(key + "=" + val);

				bw.newLine();

			}

		}

		bw.flush();

	}

	private static void writeComments(BufferedWriter bw, String comments)

			throws IOException {

		bw.write("#");

		int len = comments.length();

		int current = 0;

		int last = 0;

		while (current < len) {

			char c = comments.charAt(current);

			if (c == '\n' || c == '\r') {

				if (last != current)
					bw.write(comments.substring(last, current));

				bw.newLine();

				if (c == '\r' &&

						current != len - 1 &&

						comments.charAt(current + 1) == '\n') {

					current++;

				}

				if (current == len - 1 ||

						(comments.charAt(current + 1) != '#' &&

								comments.charAt(current + 1) != '!'))

					bw.write("#");

				last = current + 1;

			}

			current++;
		}

		if (last != current)
			bw.write(comments.substring(last, current));

		bw.newLine();

	}
}
