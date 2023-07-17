package ru.netology.page;

import ru.iteco.fmhandroid.R;

public class LoginPage {
    public MainPage validLogin(String login, String password) {
        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input_layout));
        textInputEditText.check(matches(isDisplayed()));
        textInputEditText.perform(replaceText(login), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(withId(R.id.password_text_input_layout));
        textInputEditText3.check(matches(isDisplayed()));
        textInputEditText3.perform(replaceText(password), closeSoftKeyboard());



        return new MainPage();
    }
}
