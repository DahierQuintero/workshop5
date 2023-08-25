import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

    private static Stack<HtmlTag> isValidHtml (Queue<HtmlTag> queue) {
        Stack<HtmlTag> stack = new Stack<>();
        for (HtmlTag htmlTag: queue) {
            if (htmlTag.isOpenTag())
                stack.push(htmlTag);
            else if (!htmlTag.isSelfClosing()) {
                if (stack.empty())
                    return null;

                else if (htmlTag.matches(stack.peek()))
                    stack.pop();

                else if (!htmlTag.matches(stack.peek()))
                    return null;

            else {
                if (stack.empty())
                    return null;
                }
            }
        }
        return stack;
    }


    public static void main(String[] args) throws IOException {

        Queue<HtmlTag> htmlTags = HtmlReader.getTagsFromHtmlFile("C:\\Users\\Dilan Quintero\\proyecto1\\blogpost.html");
        Stack<HtmlTag> validHtml = isValidHtml(htmlTags);
        System.out.println(validHtml);

    }
}
