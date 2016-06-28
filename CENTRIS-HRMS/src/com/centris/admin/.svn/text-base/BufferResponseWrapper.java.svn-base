package com.centris.admin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;



public  class BufferResponseWrapper extends HttpServletResponseWrapper
{

    MyServletOutputStream stream = new MyServletOutputStream();

    public BufferResponseWrapper(HttpServletResponse httpServletResponse)
    {
        super(httpServletResponse);
    }

    public ServletOutputStream getOutputStream() throws IOException
    {
        return stream;
    }

    public PrintWriter getWriter() throws IOException
    {
        return new PrintWriter(stream);
    }

    public byte[] getWrapperBytes()
    {
        return stream.getBytes();
    }
}

  class MyServletOutputStream extends ServletOutputStream
{
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    public void write(int b) throws IOException
    {
        out.write(b);
      
    }
    public void write(byte[] b) throws IOException
    {
        out.write(b);
      
    }

    public byte[] getBytes()
    {
        return out.toByteArray();
    }

}