package jdbc.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Request {
    private String url;
    private RequestMethod method;
    private Map<String, String[]>params;

    public Request(String url, RequestMethod method, Map<String, String[]>params) {
        this.url = url;
        this.method = method;
        this.params = params;
    }

    public String getParameterByName(String login) {
        return  params.get(login)[0];
    }

    public enum RequestMethod {
        GET,
        POST
    }

    public  static Request of(String url, RequestMethod method){
        return new Request(url, method,new HashMap<>());
    }

    public  static Request of(String url, RequestMethod method, Map<String, String[]>params){
        return new Request(url, method, params);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(url, request.url) &&
                method == request.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, method);
    }
}