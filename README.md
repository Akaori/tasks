# TASKS

```mermaid
classDiagram
Identifiable <|-- BaseTask
BaseTask <|-- PersonalTask
BaseTask <|-- StudyTask
BaseTask <|-- WorkTask
BaseTask : -count: int
BaseTask : -id: Long
BaseTask : -title: String
BaseTask : -description: String
BaseTask : -deadline: String
BaseTask : -tag: Tag
BaseTask : +BaseTask(title, description, deadline)
BaseTask : +equals(obj): boolean
BaseTask : +toString(): String
PersonalTask : +PersonalTask(title, description, deadline)
PersonalTask : +tag: Tag.PERSONAL
StudyTask : +StudyTask(title, description, deadline)
StudyTask : +tag: Tag.STUDY
WorkTask : +WorkTask(title, description, deadline)
WorkTask : +tag: Tag.WORK
Identifiable : +getId(): U
```

## 🔍 Sobre

Aplicativo de Gerenciamento de Tarefas via Console

## 💻 Instruções para rodar

- Clonar repositório

```
git clone https://github.com/Akaori/tasks.git
```

- Abrir projeto no IntelliJ
- Abrir arquivo `src > main > java > br.com.adatask > Main`

![img.png](img/main.png)

- Clicar no `play` para rodar o projeto

## 🖥️ Tecnologias

- Backend:

<div align="center">
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/192108890-200809d1-439c-4e23-90d3-b090cf9a4eea.png" alt="InteliJ" title="InteliJ"/></code>
	<code><img width="50" src="https://user-images.githubusercontent.com/25181517/117201156-9a724800-adec-11eb-9a9d-3cd0f67da4bc.png" alt="Java" title="Java"/></code>
</div>