package angiotool;

import java.util.StringTokenizer;
import java.util.ArrayList;
import ij.plugin.PlugIn;
import ij.WindowManager;
import ij.IJ;
import ij.ImagePlus;
import ij.Macro;
import ij.gui.GenericDialog;
import angiotool.gui.AngioToolGUI;

/**
 * This is an ImageJ plugin that serves to start AngioTool
 *
 * @author Jan Eglinger, Ivan Chang
 */
public class Angio_Tool implements PlugIn {

	public static AngioToolGUI allantoisGUI;
	 /**
	 * This method gets called by ImageJ / Fiji.
	 *
	 * @param arg can be specified in plugins.config
	 * @see ij.plugin.PlugIn#run(java.lang.String)
	 */
	@Override
	public void run(String arg) {

		allantoisGUI = new AngioToolGUI();
        	allantoisGUI.setVisible(true);
        	allantoisGUI.setLocation(10,10);
		ImagePlus inputImage;


		if (null == WindowManager.getCurrentImage())
		{
			inputImage = IJ.openImage();
			if (null == inputImage) return; // user canceled open dialog
		}
		else
			inputImage = WindowManager.getCurrentImage();


		allantoisGUI.openCurrentImage(inputImage);

		final String options = Macro.getOptions();

		if (options == null || options.isEmpty() || options.trim().isEmpty())
    			System.out.println("options is null, empty or blank.");
		else {
      			System.out.println("Got options " + options);
			processArg(options);
		}
	}

	private void processArg(String options) {

		final ArrayList<String> args = new ArrayList<String>();
		final StringTokenizer tokenizer = new StringTokenizer(options);
	  	final String sigmasString;
		final int threshold_low, threshold_high, smallParticlesValue, fillHolesValue;

		while (tokenizer.hasMoreTokens())
		{
		            args.add(tokenizer.nextToken(" "));
		}
		sigmasString = args.get(0);
		threshold_low = Integer.parseInt(args.get(1));
		threshold_high = Integer.parseInt(args.get(2));
		smallParticlesValue = Integer.parseInt(args.get(3));
		fillHolesValue = Integer.parseInt(args.get(4));



	  allantoisGUI.doAnalysisHeadless(sigmasString, threshold_low, threshold_high, smallParticlesValue, fillHolesValue);
	}

	private static void pause(int ms) {
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
        System.err.format("IOException: %s%n", e);
    }
	}
}
