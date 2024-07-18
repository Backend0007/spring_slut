package slut.com.slut.service.responseService;



public class Response {
    private final int _code;
    private final String _notification;

    private Response(Builder builder){
        this._code = builder.code;
        this._notification = builder.notification;
    }




    public static class Builder{
        private Integer code;
        private String notification;

        public Builder code(Integer code){
            this.code = code;
            return this;
        }

        public Builder notification(String notification){
            this.notification = notification;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }


}
