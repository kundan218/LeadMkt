/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jspl.lms.util;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextRenderer;


/**
 *
 * @ Anoop Pandey
 */
public class StringToPdfConvertor {

    public static void create(OutputStream outputStream, String html) {
        ITextRenderer renderer = new ITextRenderer();
        try {
// we need to create the target PDF
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream, false);
        } catch (Exception ex) {
        } finally {
            renderer.finishPDF();
        }
    }
    
    
    public static ByteArrayOutputStream create(String html) {
        ITextRenderer renderer = new ITextRenderer();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
// we need to create the target PDF
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(bos, false);
        } catch (Exception ex) {
        } finally {
            renderer.finishPDF();
        }
        return bos;
    }
}
