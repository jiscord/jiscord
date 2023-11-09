package site.lifix.jiscord.utility.app;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Language {
    ID("id", "Indonesian", "Bahasa Indonesia"),
    DA("da", "Danish", "Dansk"),
    DE("de", "German", "Deutsch"),
    EN_GB("en-GB", "English, UK", "English, UK"),
    EN_US("en-US", "English, US", "English, US"),
    ES_ES("es-ES", "Spanish", "Español"),
    FR("fr", "French", "Français"),
    HR("hr", "Croatian", "Hrvatski"),
    IT("it", "Italian", "Italiano"),
    LT("lt", "Lithuanian", "Lietuviškai"),
    HU("hu", "Hungarian", "Magyar"),
    NL("nl", "Dutch", "Nederlands"),
    NO("no", "Norwegian", "Norsk"),
    PL("pl", "Polish", "Polski"),
    PT_BR("pt-BR", "Portuguese, Brazilian", "Português do Brasil"),
    RO("ro", "Romanian", "Română"),
    FI("fi", "Finnish", "Suomi"),
    SV_SE("sv-SE", "Swedish", "Svenska"),
    VI("vi", "Vietnamese", "Tiếng Việt"),
    TR("tr", "Turkish", "Türkçe"),
    CS("cs", "Czech", "Čeština"),
    EL("el", "Greek", "Ελληνικά"),
    BG("bg", "Bulgarian", "български"),
    RU("ru", "Russian", "Pусский"),
    UK("uk", "Ukrainian", "Українська"),
    HI("hi", "Hindi", "हिन्दी"),
    TH("th", "Thai", "ไทย"),
    ZH_CN("zh-CN", "Chinese, China", "中文"),
    JA("ja", "Japanese", "日本語"),
    ZH_TW("zh-TW", "Chinese, Taiwan", "繁體中文"),
    KO("ko", "Korean", "한국어");

    private final String locale;
    private final String englishName;
    private final String nativeName;

    public static List<Language> getAllLanguages() {
        return Arrays.asList(Language.values());
    }

    public String get(TranslationKey key) {
        // this should probably be implemented properly yk
        // logic should go as follows:
        //  if language (load if not loaded) has key
        //  > return key->translated
        //  else
        //  > return key
        return key.name();
    }
}
