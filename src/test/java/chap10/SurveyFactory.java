package chap10;

public class SurveyFactory {
    public static Survey createApprovedSuvery(long id) {
        return new Survey(id);
    }
}
