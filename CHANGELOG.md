# Changelog

All notable changes to this project will be documented in this file.

The format follows [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)
and this project adheres to [Semantic Versioning](https://semver.org/).

---

## [v2.1.0] - 2025-07-19

### Added
- Implemented a drink history feature: the machine now stores all drinks prepared during the session.
- Added a new menu option to display the drink history.
- Adjusted program flow to support the new drink history functionality.

---

## [v2.0.0] - 2025-07-17

### Added
- Custom exceptions for machine status and coffee selection errors.
- Methods to remove ingredients from the machine.

### Changed
- Fully refactored the `makeCoffee()` method to throw exceptions.
- Restructured status reporting and user messages.

### Removed
- Obsolete commented-out code.
- Unused import statements.

---

## [v1.0.0] - 2025-07-16

### Added
- Initial version of the CoffeeMachine with coffee preparation, ingredient validation, and status reporting.
