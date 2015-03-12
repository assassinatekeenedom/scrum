package com.keene.mepbm.pdfparser.reader;

import com.keene.mepbm.core.Processor;
import com.keene.mepbm.pdfparser.reader.pdf.PDFProcessor;
import com.keene.mepbm.pdfparser.reader.pdf.PDFReaderData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class METurnReader extends Processor<METurnReaderData> {

    public METurnReader(String path) {
        METurnReaderData data = new METurnReaderData();
        this.setData(data);
        this.getData().setPath(path);
    }

    @Override
    public void process() {
        PDFProcessor pdfProcessor = new PDFProcessor();
        PDFReaderData pdfData = new PDFReaderData(this.getData());
        pdfProcessor.setData(pdfData);
        this.add(pdfProcessor);
        super.process();
        this.remove(pdfProcessor);
    }

    public static METurnReader getInstance(String file) {
        return new METurnReader(file);
    }

    public static List<METurnReader> getInstances(List<String> files) {
        List<METurnReader> reader = new ArrayList<METurnReader>();
        for (String file : files) {
            reader.add(new METurnReader(file));
        }
        return reader;
    }

    public static List<METurnReader> getInstanceDirectory(String adirectory) {
        List<METurnReader> reader = new ArrayList<METurnReader>();
        File basedir = new File(adirectory);
        String[] games = basedir.list();
        if (games != null) {
            for (int i = 0; i < games.length; i++) {
                String directory = games[i];
                if (directory.contains("game") || directory.contains("grudge")) {
                    File subdir = new File(adirectory + directory);
                    String[] turns = subdir.list();
                    if (turns != null) {
                        for (int x = 0; x < turns.length; x++) {
                            String turn = turns[x];
                            if (turn.toLowerCase().contains("turn")) {
                                turn = adirectory + directory + "/" + turn;
                                File pdfdir = new File(turn);
                                String[] pdfs = pdfdir.list();
                                if (pdfs != null) {
                                    for (int y = 0; y < pdfs.length; y++) {
                                        String pdf = pdfs[y];
                                        if (pdf.contains(".pdf")) {
                                            reader.add(new METurnReader(turn + "/" + pdf.replace(".pdf", "")));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return reader;
    }
}
