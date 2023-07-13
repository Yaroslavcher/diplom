package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginAndLogoutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void loginAndLogoutTest() {
        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input_layout));
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(withId(R.id.password_text_input_layout));
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction textInputEditText3 = onView(withId(R.id.password_text_input_layout));
        textInputEditText3.perform(pressImeActionButton());

        ViewInteraction materialButton = onView(withId(R.id.enter_button));
        materialButton.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));

        ViewInteraction linearLayout = onView(
                allOf(withId(R.id.container_list_news_include_on_fragment_main),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class))),
                        isDisplayed()));
        linearLayout.check(matches(isDisplayed()));

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
                        childAtPosition(
                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialTextView = onView(
                allOf(withId(android.R.id.title), withText("Log out"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialTextView.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
