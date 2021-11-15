use std::cmp::Ordering;
use std::io;

use ferris_says::say;
use rand::Rng;

fn main() {
    ferris_hi();
    guessing_game();
}

fn guessing_game() {
    println!("Guess the number!");

    let secret_number = rand::thread_rng().gen_range(1..=100);

    println!("The secret number is {}", secret_number);

    loop {
        println!("Input your guess:");

        let mut guess = String::new();

        io::stdin()
            .read_line(&mut guess)
            .expect("Failed to read line");

        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Please enter a number");
                continue;
            }
        };

        print!("You guessed {} ... ", guess);

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Higher..."),
            Ordering::Greater => println!("Lower..."),
            Ordering::Equal => {
                println!("That's right!");
                break;
            },
        }
    }
}

fn ferris_hi() {
    let stdout = io::stdout();

    let message = String::from("Hello fello Rustaceans!");
    let width = message.chars().count();

    let mut writer = io::BufWriter::new(stdout.lock());

    say(message.as_bytes(), width, &mut writer).unwrap();
}