import SwiftUI
import shared

struct LanguageDisplay: View {
    let language: UiLanguage
    
    var body: some View {
        HStack(alignment: .center) {
            SmallLanguageIcon(language: language)
                .padding(.trailing, 5)
            Text(language.language.langName)
                .foregroundColor(.lightBlue)
        }
    }
}

struct LanguageDisplay_Previews: PreviewProvider {
    static var previews: some View {
        LanguageDisplay(
            language: UiLanguage(language: .arabic, imageName: "arabic")
        )
    }
}
