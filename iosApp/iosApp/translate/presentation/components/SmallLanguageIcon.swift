import SwiftUI
import shared

struct SmallLanguageIcon: View {
    let language: UiLanguage
    
    var body: some View {
        Image(uiImage: UIImage(named: language.imageName)!)
            .resizable()
            .frame(width: 30, height: 30)
    }
}

struct SmallLanguageIcon_Previews: PreviewProvider {
    static var previews: some View {
        SmallLanguageIcon(
            language: UiLanguage(language: .arabic, imageName: "arabic")
        )
    }
}
