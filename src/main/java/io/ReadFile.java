package io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

	public static String readFile( String iPath, Charset iEncoding ) {
		byte[] lEncoded = null;
		try {
			lEncoded = Files.readAllBytes( Paths.get( iPath ) );
		} catch (IOException e) {
	         System.err.println( "I/O error while reading file" );
			e.printStackTrace();
		}
		return new String( lEncoded, iEncoding );
	}

	public static List<String> readFileToList( String iPath, Charset iEncoding ) {
		try {
			return Files.readAllLines( Paths.get( iPath ), iEncoding );
		} catch ( IOException lIOE ) {
	         System.err.println( "I/O error while reading file" );
			lIOE.printStackTrace();
		}
		return new ArrayList<String>();
	}

}
