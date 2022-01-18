import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	JTextPane textArea;
	
	Color textColor = new Color(121,171,152);
	
	public GUI() {
		textArea = new JTextPane();
		
		setSize(600, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("RMS Server");
		setResizable(false);
		setVisible(true);
		textArea.setEditable(false);
		textArea.setBackground(Color.black);
		JScrollPane scroll = new JScrollPane(textArea);
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		add(scroll);
		redirectSystemStreams();
	}

	  private void updateTextArea(final String text, Color c) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
		        StyleContext sc = StyleContext.getDefaultStyleContext();
		        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

		        int len = textArea.getDocument().getLength();
		        textArea.setCaretPosition(len);
		        textArea.setCharacterAttributes(aset, false);
		        textArea.setEditable(true);
		        textArea.replaceSelection(text);
		        textArea.setEditable(false);
	      }
	    });
	  }
	  
	/*
	 *  Set new Console
	 */
	  private void redirectSystemStreams() {
		//Color for errors
	    OutputStream out = new OutputStream() {
	      @Override
	      public void write(int b) throws IOException {
	        updateTextArea(String.valueOf((char) b), textColor);
	      }

	      @Override
	      public void write(byte[] b, int off, int len) throws IOException {
	        updateTextArea(new String(b, off, len), textColor);
	      }

	      @Override
	      public void write(byte[] b) throws IOException {
	        write(b, 0, b.length);
	      }
	    };
	    //Red for errors
	    OutputStream oute = new OutputStream() {
		      @Override
		      public void write(int b) throws IOException {
		        updateTextArea(String.valueOf((char) b), Color.red);
		      }

		      @Override
		      public void write(byte[] b, int off, int len) throws IOException {
		        updateTextArea(new String(b, off, len), Color.red);
		      }

		      @Override
		      public void write(byte[] b) throws IOException {
		        write(b, 0, b.length);
		      }
		    };
	    

	    System.setOut(new PrintStream(out, true));
	    System.setErr(new PrintStream(oute, true));
	  }
}
