#### Funcionalidades a Modelar
1. **Reprodutor Musical**
   - Métodos: `tocar()`, `pausar()`, `selecionarMusica(String musica)`
2. **Aparelho Telefônico**
   - Métodos: `ligar(String numero)`, `atender()`, `iniciarCorreioVoz()`
3. **Navegador na Internet**
   - Métodos: `exibirPagina(String url)`, `adicionarNovaAba()`, `atualizarPagina()`

classDiagram
    class ReprodutorMusical {
     -nome: String
     -duracao: Double
     -artista: String  
     -playlist: String
     +tocar(): void
     +pausar(): void
     +selecionarMusica(musica: String): void
    }

    class AparelhoTelefonico {
    -numero: Int
    +ligar(numero: String): void  
    +atender(): void
    +iniciarCorreioVoz(): void
    }

    class NavegadorInternet {
    +exibirPagina(url: String)
    +adicionarNovaAba(): void
    +atualizarPagina(): void
    +ir(): void
    }

    class iPhone {
        +ligar(): void
        +desligar(): void
    }

    iPhone --> ReprodutorMusical
    iPhone --> AparelhoTelefonico
    iPhone --> NavegadorInternet
