<h3>O App de Tarefas Gamificado é uma aplicação inovadora desenvolvida em Java que organiza as tarefas diárias dos usuários de forma única, categorizando-as em quatro atributos principais: Inteligência, Força, Destreza e Cultura. Cada tarefa do usuário será associada a um desses pilares, transformando o gerenciamento de atividades diárias em uma experiência gamificada, onde o progresso em diferentes áreas é refletido no desempenho do usuário.
Especificações Principais:</h3>
<p>
    Cadastro de Tarefas: O usuário pode criar tarefas com título, descrição e data de vencimento. Cada tarefa será atribuída a uma classe específica (Inteligência, Força, Destreza ou Cultura), de acordo com a natureza da atividade (por exemplo, "Resolver um problema matemático" seria associada a Inteligência, enquanto "Levantar pesos na academia" se encaixaria em Força).

 Classes de Atributos:
        Inteligência: Tarefas relacionadas a aprendizado, resolução de problemas, leitura, etc.
        Força: Tarefas físicas, como exercícios, atividades que envolvem resistência física ou força bruta.
        Destreza: Tarefas que exigem habilidades motoras finas, como desenhar, programar, tocar um instrumento, etc.
        Cultura: Tarefas relacionadas a atividades culturais, como visitar museus, assistir filmes, aprender uma nova língua, entre outros.

Sistema de Pontuação: Cada tarefa concluída contribui para o desenvolvimento do "atributo" relacionado (Inteligência, Força, Destreza ou Cultura), permitindo ao usuário monitorar seu progresso em cada área. A pontuação pode ser visualizada de forma separada para cada classe.

Interface Interativa e Visual: A interface do app oferece uma visão clara de quais áreas (atributos) o usuário tem mais desenvolvido e quais precisam de mais atenção. Pode-se ver gráficos ou barras de progresso que mostram o avanço em cada um dos pilares.

Desafios e Metas: O app inclui desafios semanais ou mensais relacionados a cada classe, oferecendo uma abordagem gamificada, onde o usuário se engaja ao tentar atingir metas específicas, como "Completar 5 tarefas de Inteligência esta semana" ou "Treinar Força por 10 horas no mês".

Notificações e Lembretes: O app envia lembretes inteligentes para incentivar o usuário a completar suas tarefas, com base nas prioridades e categorias associadas às suas metas.

Integração com Calendário: O app pode ser sincronizado com o calendário do usuário para sugerir tarefas de diferentes categorias com base na agenda existente, equilibrando as áreas de atividade e otimizando o tempo.

Relatórios de Progresso: O app oferece relatórios periódicos sobre o desempenho em cada área, permitindo ao usuário acompanhar sua evolução ao longo do tempo.
</p>
<h2>Motivações para o Desenvolvimento:</h2>
<p>
    Gamificação do Gerenciamento de Tarefas: Ao introduzir as categorias "Inteligência", "Força", "Destreza" e "Cultura", o app transforma o simples gerenciamento de tarefas em uma experiência mais envolvente e divertida. Cada tarefa concluída não é apenas uma simples atividade, mas uma conquista que impacta no desenvolvimento de áreas específicas da vida do usuário.

Equilíbrio nas Áreas da Vida: O objetivo do app é ajudar os usuários a se manterem equilibrados em todas as esferas importantes da vida. Ao atribuir tarefas a essas quatro categorias, o usuário pode ver de forma clara em quais áreas está se dedicando mais e em quais precisa melhorar.

Motivação Contínua: Com a gamificação e o sistema de pontos e desafios, o app visa aumentar a motivação do usuário. A sensação de progresso nas quatro áreas oferece uma forma tangível de medir o sucesso e alcança uma satisfação pessoal ao completar desafios.

Aplicação dos 4 Pilares de POO:
        Encapsulamento: As informações sobre cada tarefa são encapsuladas em objetos de classe, garantindo que cada atributo da tarefa (como título, descrição e classe) seja acessado e manipulado de forma controlada.
        Herança: O app utiliza a herança para criar diferentes tipos de tarefas (por exemplo, TarefaInteligencia, TarefaForca), todas herdando de uma classe base comum Tarefa, mas com comportamentos específicos para cada tipo.
        Polimorfismo: O polimorfismo é utilizado ao permitir que o mesmo método (como completarTarefa()) seja aplicado a diferentes tipos de tarefa, com resultados distintos dependendo da classe.
        Abstração: O app abstrai o conceito de tarefa, permitindo que o usuário interaja com uma interface simples, enquanto a lógica complexa de categorização e pontuação acontece por trás.

Desenvolvimento e Manutenção Simples: A utilização dos pilares de POO garante que o código seja bem estruturado e escalável. O modelo orientado a objetos facilita a manutenção do aplicativo, permitindo a adição de novas funcionalidades ou a modificação das existentes de forma eficiente.
</p>
Conclusão

O App de Tarefas Gamificado visa não apenas ajudar os usuários a gerenciar suas tarefas diárias, mas também a desenvolver habilidades em áreas-chave da vida, através de uma abordagem motivacional e estruturada. Com a aplicação dos pilares de Programação Orientada a Objetos (POO), o app é robusto, fácil de manter e altamente escalável, proporcionando uma experiência fluida e envolvente para o usuário.</p>
