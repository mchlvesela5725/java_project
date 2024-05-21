package cz.vsb.fei.java2;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

import java.net.URL;
import java.util.Objects;

@QuarkusMain
public class RunServer {
	public static void main(String[] args) {
		Quarkus.run(args);
	}
}
